package Exercices.Interview;

import java.util.*;
import java.util.random.RandomGenerator;

class Request {
    public static Response call(String host) {
        return new Response();
    }
}

class Response {
    RandomGenerator random = RandomGenerator.of("Random");

    public int getStatus() {
        if (random.nextInt() % 2 == 0) {
            return 200;
        } else {
            return 500;
        }
    }
}

class ApiClient {
    private Map<String, Deque<Integer>> storage;
    private final int ERRORS_QUEUE_SIZE = 3;

    ApiClient() {
        storage = new HashMap<>();
    }

    private int getCurrentTime() {
        return 0;
    }

    public Response call(String host) {
        int currentTime = getCurrentTime();
        Deque<Integer> hostQueue = storage.get(host);

        if (hostQueue == null) {
            Response resp = Request.call(host);
            Deque<Integer> newQueue = new LinkedList<>();

            if (resp.getStatus() != 200) {
                newQueue.push(currentTime);
                storage.put(host, newQueue);
            }

            return resp;
        } else if (hostQueue != null && hostQueue.size() < ERRORS_QUEUE_SIZE) {
            Response resp = Request.call(host);

            if (resp.getStatus() != 200) {
                hostQueue.push(currentTime);
            }

            return resp;

        } else if (hostQueue.getFirst() - currentTime >= 5) {
            Response resp = Request.call(host);

            if (resp.getStatus() != 200) {
                hostQueue.push(currentTime);
            } else {
                storage.remove(host);
            }

            return resp;
        } else {
            return null;
        }
    }
}

class TestApiCLient {
    public static void main(String[] args) {

    }
}
