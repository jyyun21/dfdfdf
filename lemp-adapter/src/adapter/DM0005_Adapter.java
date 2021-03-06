package adapter;

import java.util.HashMap;

import kr.co.ldcc.lemp.adapter.AbstractTemplateAdapter;
import kr.co.ldcc.lemp.adapter.DBAdapter;
import kr.co.ldcc.lemp.hybrid.adapter.api.Adapter;
import kr.co.ldcc.lemp.hybrid.adapter.api.IAdapterJob;
import kr.co.ldcc.lemp.hybrid.common.server.JsonAdaptorObject;
import model.DM0005.DM0005Request;
import model.DM0005.DM0005Request_Body;
import model.DM0005.DM0005Response;
import model.header.DMheader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Adapter(trcode = { "DM0005" })
public class DM0005_Adapter extends AbstractTemplateAdapter implements
		IAdapterJob {

	private static final Logger logger = LoggerFactory
			.getLogger(DM0005_Adapter.class);
	@Autowired
	private DBAdapter dbAdapter;

	public JsonAdaptorObject onProcess(JsonAdaptorObject obj) {

		DM0005Request request = new DM0005Request(obj);
		DMheader header = request.getHeader();
		DM0005Request_Body reqBody = request.getBody();

		//Start Business Logic Coding!
		try {
			HashMap<String, Object> input = new HashMap<String, Object>();
			input.put("docId", reqBody.getDocId());
			dbAdapter.delete("LegacyDB", "DM0005.5001", input);
			
			DM0005Response response = new DM0005Response();
			response.setHeader(header);
			
		//  성공시
			return makeResponse(obj, response.toJsonNode()); // DM0001Response를 JSON형식으로 넘겨줘야함
			
		} catch (Exception e) {
			logger.error("에러 발생",e);
			return makeFailResponse("DM0002 에러발생");
		}
	}

}
