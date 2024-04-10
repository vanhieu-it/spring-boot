package org.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties("server")
@Data
public class ServerProperties {

        private String email;
        private List<Cluster> cluster = new ArrayList<>();


        @Data
        public static class Cluster {
            private String ip;
            private String path;

            @Override
            public String toString() {
                return "Cluster{" +
                        "ip='" + ip + '\'' +
                        ", path='" + path + '\'' +
                        '}';
            }
        }
        @Override
        public String toString() {
            return "ServerProperties{" +
                    "email='" + email + '\'' +
                    ", cluster=" + cluster +
                    '}';
        }

}
