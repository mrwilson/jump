MVN=mvn

build: test
	@$(MVN) clean package

test:
	@$(MVN) clean test
