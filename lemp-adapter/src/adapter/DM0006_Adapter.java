package adapter;

import java.util.HashMap;

import kr.co.ldcc.lemp.adapter.AbstractTemplateAdapter;
import kr.co.ldcc.lemp.adapter.DBAdapter;
import kr.co.ldcc.lemp.hybrid.adapter.api.Adapter;
import kr.co.ldcc.lemp.hybrid.adapter.api.IAdapterJob;
import kr.co.ldcc.lemp.hybrid.common.server.JsonAdaptorObject;
import model.DM0003.DM0003Response_Body;
import model.DM0006.DM0006Request;
import model.DM0006.DM0006Request_Body;
import model.DM0006.DM0006Response;
import model.DM0006.DM0006Response_Body;
import model.header.DMheader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.org.apache.bcel.internal.generic.Select;

@Adapter(trcode = { "DM0006" })
public class DM0006_Adapter extends AbstractTemplateAdapter implements
		IAdapterJob {

	private static final Logger logger = LoggerFactory
			.getLogger(DM0006_Adapter.class);
	@Autowired
	private DBAdapter dbAdapter;

	public JsonAdaptorObject onProcess(JsonAdaptorObject obj) {

		DM0006Request request = new DM0006Request(obj);
		DMheader header = request.getHeader();
		DM0006Request_Body reqBody = request.getBody();

		//Start Business Logic Coding!
		try {
			HashMap<String, Object> input = new HashMap<String, Object>();
			input.put("title", reqBody.getTitle());
			input.put("contents", reqBody.getContents());
			input.put("docId", reqBody.getDocId());
			
			dbAdapter.update("LegacyDB", "DM0006.6001", input);
			
			DM0006Response response = new DM0006Response();
			
			response.setHeader(header);
			
			
			//  성공시
			return makeResponse(obj, response.toJsonNode()); // DM0001Response를 JSON형식으로 넘겨줘야함
			
		} catch (Exception e) {
			logger.error("에러 발생",e);
			return makeFailResponse("DM0002 에러발생");
		}
	}

}
