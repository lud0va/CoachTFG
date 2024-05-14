Feature:comprueba que el usuario se haga login y register correctamente
  Background:
    Given una lista de usuarios
    #id   Email    Contraseña  Rol
    #1  si@gmail    sisi      Coach
    #2  no@gmail    nono      Coachee

  Scenario: un coach se quiere logear con datos correctos
      Given email
      #hola@gmail.com
      And contraseña
      #hola123
      When inicia sesion
      Then Devuelve el accesstoken y refreshtoken con permisos de coach

  Scenario: un coachee se quiere logear con datos correctos
    Given email
      #coachee@gmail.com
    And contraseña
      #coachee123
    When inicia sesion
    Then Devuelve el accesstoken y refreshtoken con permisos de coachee

  Scenario: un coach se quiere logear con una contraseña incorrecta
    Given email
      #hola@gmail.com
    And contraseña
      #adios123
    When inicia sesion
    Then Devuelve un error



  Scenario: un coach se quiere registrar con datos correctos
    Given email
      #adios@gmail.com
    And contraseña
      #hola123
    And nombre
    #hola
    And apellido
    #hola
    When se registra
    Then Devuelve un true
    And se crea un nuevo coach

  Scenario: un coachee se quiere registrar con datos correctos
    Given email
      #adios@gmail.com
    And contraseña
      #hola123
    And nombre
    #hola
    And apellido
    #hola
    And codigoDelCoach
    #aaaaa123
    When se registra
    Then Devuelve un true
    And se crea un coachee
  Scenario: un coach se quiere registrar con un email repetido
    Given email
      #hola@gmail.com
    And contraseña
      #hola123
    And nombre
    #hola
    And apellido
    #hola
    When se registra
    Then Devuelve un false

  Scenario: un coach se quiere registrar con un email invalido
    Given email
      #hola
    And contraseña
      #hola123
    And nombre
    #hola
    And apellido
    #hola
    When se registra
    Then Devuelve un false


    Scenario: El token de un usuario caduca (sin que el usuario se de cuenta)
        Given : el token de acceso del usuario
        When :el token de refresco esta caducado
        And : el usuario intenta llamar algun metodo
        Then se pide un nuevo token de acceso con el token de refresco