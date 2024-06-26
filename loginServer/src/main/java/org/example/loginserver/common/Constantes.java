package org.example.loginserver.common;

public class Constantes {
    public static final String USER = "user";
    public static final String USERNAMEP = "username";
    public static final String CREDENTIAL_INVALIDA = "Credential invalida";
    public static final String USUARIO_NO_ENCONTRADO = "Usuario no encontrado ";
    public static final String ACCESS_TOKEN = "access_token";
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String TOKEN_INVALIDO = "Token invalido  ";
    public static final String ESE_USER_YA_EXISTE = "Ese user ya existe";
    public static final String USER_NOT_FOUND = "User not found";
    public static final String ERROR_WHILE_PROCESSING_TOKENS = "Error while processing tokens";
    public static final String SECURITY_JWT_KEYSTORE_NAME = "${application.security.jwt.keystoreName}";
    public static final String APPLICATION_SECURITY_JWT_CLAVE = "${application.security.jwt.clave}";
    public static final String SECURITY_JWT_SERVER_NAME = "${application.security.jwt.serverName}";
    public static final String APPLICATION_SECURITY_JWT_ACCESS_EXPIRATION = "${application.security.jwt.access-expiration}";
    public static final String APPLICATION_SECURITY_JWT_REFRESH_TOKEN_EXPIRATION = "${application.security.jwt.refresh-token.expiration}";
    public static final String NAME = "name";
    public static final String LASTNAME = "lastname";
    public static final String COACH = "coach";
    public static final String IDCOACH = "id";
    public static final String FECHA_EXP_LICENCIA = "fecha_exp_licencia";
    public static final String CODE = "coach_code";
    public static final String GET_USER_BY_EMAIL = "/getUserByEmail";

    private Constantes() {
    }

    public static final String SERVERNAME = "serverName";


    public static final String CLAVESERV = "clave";
    public static final String KEYSTORENAME = "keystoreName";
    public static final String EMAIL = "email";
    public static final String USERR = "user";
    public static final String IDUSER = "id_user";
    public static final String PASSWORD = "password";

    public static final String ROL = "rol";
    public static final String PKCS_12 = "PKCS12";
    public static final String ROLE = "role";
    public static final String ERROR_FIRMANDO_EL_ACCESS_TOKEN = "error firmando el access token";

    public static final String USUARIO_INVALIDO = "Usuario invalido";
    public static final String LOGIN = "/login";
    public static final String REFRESHTOKEN = "refreshtoken";
    public static final String GETACCESSTOKEN = "/getAccessToken";
    public static final String REGISTER = "/registerCoach";

    public static final String REGISTERCOACHEE = "/registerCoachee";
    public static final String ACCESS = "access";
    public static final String REFRESH = "refresh";
    public static final String V_3_API_DOCS = "/v3/api-docs/**";
    public static final String SWAGGER_UI = "/swagger-ui/**";
    public static final String V_2_API_DOCS = "/v2/api-docs/**";
    public static final String SWAGGER_RESOURCES = "/swagger-resources/**";
}
