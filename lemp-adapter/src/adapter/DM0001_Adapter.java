package adapter;

import java.util.HashMap;

import kr.co.ldcc.lemp.adapter.AbstractTemplateAdapter;
import kr.co.ldcc.lemp.adapter.DBAdapter;
import kr.co.ldcc.lemp.hybrid.adapter.api.Adapter;
import kr.co.ldcc.lemp.hybrid.adapter.api.IAdapterJob;
import kr.co.ldcc.lemp.hybrid.common.server.JsonAdaptorObject;
import model.DM0001.DM0001Request;
import model.DM0001.DM0001Request_Body;
import model.DM0001.DM0001Response;
import model.DM0001.DM0001Response_Body;
import model.header.DMheader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import data.UserDomain;

@Adapter(trcode = { "DM0001" })  //trcode는 전문코드, 요청데이터랑 전문코드 둘다 서버로 보냄
public class DM0001_Adapter extends AbstractTemplateAdapter implements
		IAdapterJob {

	private static final Logger logger = LoggerFactory
			.getLogger(DM0001_Adapter.class);
	@Autowired
	private DBAdapter dbAdapter; //spring bean으로 동작, 바로 객체를 얻어옴

	public JsonAdaptorObject onProcess(JsonAdaptorObject obj) {

		DM0001Request request = new DM0001Request(obj);
		DMheader header = request.getHeader();
		DM0001Request_Body reqBody = request.getBody();

		//Start Business Logic Coding!
		try {
			String userId = reqBody.getUserId();
			String password = reqBody.getPassword();
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("userId", userId);
			hashMap.put("password", password);
			
			UserDomain userDomain=  (UserDomain) dbAdapter.selectOne("LegacyDB", "DM0001.1001", hashMap);
			// 사용자가 없을 경우
			if(userDomain==null){
				logger.info("사용자가 없습니다");
				return makeFailResponse("사용자 정보 없음");  // 리턴형식 json ?, 응답 데이터포맷의 헤더에 있는 result필드의 값이 false로 해서 return됨
			}
			// 비번이 틀릴경우
			if(!userDomain.getPassword().equals(password)){
				logger.info("비번이 다릅니다");
				return makeFailResponse("비번이 달라요");
			}
			
			// 로그인 성공시
			DM0001Response response = new DM0001Response(); //DM0001 은 header와 body를 가지고 있다.
			DM0001Response_Body resBody = new DM0001Response_Body();
			resBody.setUserName(userDomain.getUserName());
			
			response.setHeader(header);
			response.setBody(resBody);
			
			return makeResponse(obj, response.toJsonNode()); // DM0001Response를 JSON형식으로 넘겨줘야함
			
			
		} catch (Exception e) {
			logger.error("에러 발생",e);
			
			return makeFailResponse("로그인 중 에러 발생");
		}
	}

}
