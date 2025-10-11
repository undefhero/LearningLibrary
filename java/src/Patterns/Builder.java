package Patterns;

public interface Builder<T> {
    T build();
}

class BCircle {
    private final int x, y, r;

    private BCircle(CircleBuilder cb) {
        if (cb.r < 0)
            throw new IllegalArgumentException("negative radius");
        this.x = cb.x; this.y = cb.y; this.r = cb.r;
    }

    public String publish() {
        return "x: " + x + ", y: " + y + ", r: " + r;
    }

    public static class CircleBuilder implements Builder<BCircle> {
        private int x = 0, y = 0, r = 0;

        public CircleBuilder x(int x) {
            this.x = x;
            return this;
        }

        public CircleBuilder y(int y) {
            this.y = y;
            return this;
        }

        public CircleBuilder r(int r) {
            this.r = r;
            return this;
        }

        public int x() {
            return x;
        }

        public int y() {
            return y;
        }

        public int r() {
            return r;
        }

        @Override
        public BCircle build() {
            return new BCircle(this);
        }
    }
}

class BuilderPatternExample {
    public static void main(String[] args) {
        var cb = new BCircle.CircleBuilder();
        cb.x(1).y(2).r(3);
        var circle = cb.build();

        System.out.println(circle.publish());
    }
}

