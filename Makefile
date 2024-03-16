MVN_REPORT := target/site/surefire-report.html
TIMESTAMP := $(shell date +'%F %T')

MVN_ARGS := -Dorg.slf4j.simpleLogger.showDateTime=true \
			-Dorg.slf4j.simpleLogger.dateTimeFormat="yyyy-MM-dd HH:mm:ss.SSS" \
			-Dorg.slf4j.simpleLogger.showLogName=false \
			-Dorg.slf4j.simpleLogger.showShortLogName=false \
			-Dorg.slf4j.simpleLogger.showThreadName=false

compile: 	
	@./mvnw $(MVN_ARGS) clean compile test-compile

package:
	@./mvnw $(MVN_ARGS) clean package -DskipTests

test: 
	@./mvnw $(MVN_ARGS) test

test-coverage: test
	@./mvnw $(MVN_ARGS) jacoco:report

run: 
	@./mvnw $(MVN_ARGS) clean spring-boot:run

generate-image: 
	@docker build -t hackaton-fiap-grupo50:latest .

run-stack: generate-image
	@docker compose up	
