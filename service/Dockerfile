FROM openjdk:11
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring
ENV SPRING_PROFILES_ACTIVE docker
ARG DEPENDENCY=target/dependency
VOLUME [ "/data" ]
COPY ${DEPENDENCY}/BOOT-INF/lib app/lib
COPY ${DEPENDENCY}/META-INF /app/META
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java", "-cp", "app:app/lib/*", "jp.ac.tuis.edu.taco.cloud.service.ServiceApplication"]