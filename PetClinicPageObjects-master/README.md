# PetClinicPageObjects

- The tests implemented here assume that a local version of PetClinic is running in http://localhost:8080/
- To obtain PetClinic application, go to https://github.com/spring-projects/spring-petclinic
	- Further instructions in https://github.com/spring-projects/spring-petclinic#running-petclinic-locally
	
	
## GraphWalker

To generate adaptor code, run >> mvn graphwalker:generate-sources ; it will look for model files in folder 'src/main/resources' and it will generate an interface for each model in folder 'target/generated-sources/graphwalker'.

To execute, run >> mvn graphwalker:test

##
Custom tests added to ADDPetTest;
Custom Test at the page https://bueno.inf.br/teste/painel/index.php?route=common/login, test login page.
