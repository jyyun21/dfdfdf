package adapter;

import java.util.List;

import kr.co.ldcc.lemp.adapter.AbstractTemplateAdapter;
import kr.co.ldcc.lemp.adapter.DBAdapter;
import kr.co.ldcc.lemp.hybrid.adapter.api.Adapter;
import kr.co.ldcc.lemp.hybrid.adapter.api.IAdapterJob;
import kr.co.ldcc.lemp.hybrid.common.server.JsonAdaptorObject;
import model.DM0001.DM0001Response;
import model.DM0001.DM0001Response_Body;
import model.DM0002.DM0002Request;
import model.DM0002.DM0002Request_Body;
import model.DM0002.DM0002Response;
import model.DM0002.DM0002Response_Body;
import model.DM0002.DM0002Response_Body_list;
import model.header.DMheader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Adapter(trcode = { "DM0002" })
public class DM0002_Adapter extends AbstractTemplateAdapter implements
		IAdapterJob {

	private static final Logger logger = LoggerFactory
			.getLogger(DM0002_Adapter.class);
	@Autowired
	private DBAdapter dbAdapter;

	public JsonAdaptorObject onProcess(JsonAdaptorObject obj) {

		DM0002Request request = new DM0002Request(obj);
		DMheader header = request.getHeader();
		DM0002Request_Body reqBody = request.getBody();

		//Start Business Logic Coding!
		try {
			
			int totalCount = (Integer) dbAdapter.selectOne("LegacyDB", "DM0002.2001", null);
			List<DM0002Response_Body_list> list = null;
			if(totalCount >0){
				list = (List<DM0002Response_Body_list>) dbAdapter.selectList("LegacyDB", "DM0002.2002", null);
			}
			DM0002Response response = new DM0002Response();
			DM0002Response_Body body = new DM0002Response_Body();
			response.setHeader(header);

			body.setTotalCnt(totalCount);
			body.setList(list);
			response.setBody(body);
			
			//  성공시
			return makeResponse(obj, response.toJsonNode()); // DM0001Response를 JSON형식으로 넘겨줘야함
			
		} catch (Exception e) {
			logger.error("에러 발생",e);
			
			return makeFailResponse("DM0002 에러발생");
		}
	}

}
