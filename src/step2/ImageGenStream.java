package step2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ImageGenStream {
    public static void main(String[] args) {
        // Scanner를 내가 입력한 n번 실행을 하고.
        // 거기에 걸맞은 프롬프트를 만들고
        // 그 프롬프트로 이미지 생성 요청
        Scanner sc = new Scanner(System.in);
        int size = 3;
        // // 0, 1, 2 -> int인 stream.
//        System.out.println(
//                Arrays.toString(
//                        IntStream
//                                .range(0, size)
//                                .toArray()
//                )
//        );
//        System.out.println(
//                IntStream
//                        .range(0, size)
//                        .boxed() // 자유롭게 쓸 수 있음
//                        .map(x -> {
//                            System.out.print("좋아하는 캐릭터는? : ");
//                            return sc.nextLine();
//                        }).toList()
//        );
        HttpClient httpClient = HttpClient.newHttpClient();
        String urlTemplate = "https://generativelanguage.googleapis.com/v1beta/models/%s:generateContent";
        String promptTemplate = """
        {
            "contents": [
              {
                "parts": [
                  {
                    "text": "%s(을)를 이미지로 나타내기 위한 200자 이내의 상세한 프롬프트를 작성해줘. 결과만 작성해줘."
                  }
                ]
              }
            ]
          }
        """;
        System.out.println(
                IntStream
                        .range(0, size)
                        .boxed() // 자유롭게 쓸 수 있음
                        .map(x -> {
                            System.out.print("좋아하는 캐릭터는? : ");
                            return sc.nextLine();
                        })
                        .map(x -> {
                            try {
                                return httpClient.send(
                                        HttpRequest.newBuilder()
                                            .uri(URI.create(urlTemplate.formatted("gemini-2.0-flash")))
                                            .headers("Content-Type", "application/json",
                                                        "X-goog-api-key", System.getenv("GEMINI_API_KEY"))
                                            .POST(
                                                HttpRequest.BodyPublishers.ofString(promptTemplate.formatted(x))
                                            )
                                            .build()
                                        , HttpResponse.BodyHandlers.ofString());
                            } catch (Exception ex) {
                                System.err.println(ex.getMessage());
                            }
                            return null;
                        })
                        .toList()
        );
    }

}
