Usage
=====

Build the project
------------

In the folder of the project, run the follow command:

.. code-block:: console

   $ ./gradlew build

Run the application
------------

If you give no argument, the program will stop immediatly.  
You have to give at least the id of the pokemon (Pokemon_ID).
You can precise a name of a SQLite database as a second argument (SQLiteDatabaseName).
Before you must add it into the ressource folder present in the project repository.
If the database given in second argument does not exist, the programm will use by default the local database present in the application (with the five first pokemons).
If you give no second argument, the program will use the API pokeapi.  

To run the application with command line arguments :

.. code-block:: console

   $ ./gradlew run --args="Pokemon_ID SQLiteDatabaseName"

Run the tests
-------------

.. code-block:: console

   $ ./gradlew test