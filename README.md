[![Codacy Badge](https://api.codacy.com/project/badge/Grade/c77c11b6a34b46c4bc6b299e15976f2d)](https://www.codacy.com/app/jelabra/Agents_e5a?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Arquisoft/Agents_e5a&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/Arquisoft/Agents_e5a.svg?branch=master)](https://travis-ci.org/Arquisoft/Agents_e5a)
[![codecov](https://codecov.io/gh/Arquisoft/participants1a/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/Agents_e5a)


# Agents_e5a

Skeleton of Agents module

# Authors

  Curso 2016/17:

  - David Lorenzo González (UO244795)
  - Martín Peláez Díaz (UO236974)
  - Laura Menéndez Pérez (UO244646)
  - Fernando Palazuelo Ginzo (UO244588)

  Curso 2017/18:
  
  - Miguel Villademoros García (UO251836)
  - Guillermo Díaz Pérez (UO251327)
  - Alvaro Camporro Ayala (UO251572)
  - Jesús Fernández Velasco (UO250914)


Usuarios de prueba para la aplicación:

- Email: alvaro@uniovi.es

  Contraseña: Contra
  
  Nombre: Alvaro
  
  Ubicacion: Sotrondio
  
  Kind: Persona
  
- Email: guille@uniovi.es

  Contraseña: Contra
  
  Nombre: Guille
  
  Ubicacion: Pola
  
  Kind: Persona
  
- Email: miguel@uniovi.es

  Contraseña: Contra
  
  Nombre: Miguel
  
  Ubicacion: Pravia
  
  Kind: Persona

- Email: jesus@uniovi.es

  Contraseña: Contra
  
  Nombre: Jesus
  
  Ubicacion: Mieres
  
  Kind: Persona

El módulo Agents proporciona un servicio REST para recibir una petición a localhost:8080/info de inicio sesión desde el módulo IncidenceManager, a continuación pasamos a mostar el formato de la petición y lo que devuelve este módulo como respuesta
Petición:

    {"login": "alvaro@uniovi.es", "password": "Contra", "kind": "Persona"}
    
En caso de datos de inicio de sesión correcto:
Status 200 y un json con la siguiente información

{

    "id": {
    
        "timestamp": 1528387798,
        
        "machineIdentifier": 7396683,
        
        "processIdentifier": 6848,
        
        "counter": 1587824,
        
        "time": 1528387798000,
        
        "date": 1528387798000,
        
        "timeSecond": 1528387798
    },
    "nombre": "Alvaro",
    
    "password": "Contra",
    
    "email": "alvaro@uniovi.es",
    
    "ubicacion": "Sotrondio",
    
    "identificador": "I4",
    
    "kind": "Persona",
    
    "kindCode": 2
}

En caso de que los datos de inicio de sesión sean incorrectos o falte algun dato el servicio REST devolverá respectivamente:

    {
      "status": "404",
      "error": "Usuario no encontrado"
    }
    
    {
    "status": "406",
    "error": "Faltan algunos parametros"
    }
    
    
Además el módulo proporciona una interfaz de inicio sesión introduciendo email contraseña y tipo de agente, y una vez iniciado sesión permite cambiar la contraseña del agente que haya iniciado sesión.


  
# Ejecutar el proyecto

A la hora de ejecutar el proyecto podemos ejecutarlo usando Maven (si lo tenemos instalado) abriendo una ventana de comandos en la carpeta del proyecto y ejecutando mvn spring-boot:run
Tambien se podría ejecutar a través de eclipse. Una vez arrancada la aplicación accedemos a localhost:8080 y vemos ya el formulario de login. 

Hay que tener en cuenta que en esta aplicación se usa MongoDB en la nube, con lo cual no es necesario arrancar ninguna base de datos en local.
