# JEE CORBA server

Generate the skeleton and the stub :

	\src\main\generated > idlj  -fall  ../resources/Addition.idl

launch corba server : 

	> start orbd -ORBInitialPort 1050
	
Add this arguments to java : 

	-ORBInitialPort 1050 -ORBInitialHost localhost
	
To start a CORBA registry : 

	> start orbd -ORBInitialPort 1050