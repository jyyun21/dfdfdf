package common;

import kr.co.ldcc.lemp.hybrid.common.code.Codes;

public class CodesEx extends Codes{

	/******************************
	 * 공통 사용 코드
	 ******************************/
	
	/**
	 * DATA_SOURCE
	 */
	public static final String DATA_SOURCE_DEMO_LEMPDB 			= "LEMPDB"; 	// LEMP DB
	public static final String DATA_SOURCE_DEMO_LEGACYDB 			= "LegacyDB"; 	// Legacy DB
	
	/**
	 * 에러 코드
	 */
	public static final String GROUPWARES_ERROR_PREFIX 				= "DMAT";
	public static final String SYSTEM_EXCEPTION							= "9001"; // Java 예외 발생
	public static final String SQL_EXCEPTION								= "9002"; // SQL 예외 발생
	public static final String LEAGCY_EXCEPTION							= "9003"; // LEGACY 연동 예외 발생
	
	
	/**
	 * 세션 변수
	 */
	public static final String DEMO_SESSION_USER_ID		= "userid"; 		// 사용자 ID
	public static final String DEMO_SESSION_USER_NAME	= "username"; 	// 사용자 이름
	public static final String DEMO_SESSION_DEPT_NAME	= "deptname"; 	// 부서명	
}

