package nodes;

import visitors.AstVisitor;

/**
 * Created by ssdmitriev on 29.03.16.
 */
public class BaseStatNode {
    Position position;

    public class Position {
        private int line;
        private int symbol;

        public Position(int line, int symbol) {
            this.line = line;
            this.symbol = symbol;
        }

        public String toString() {
            return line + ":" + symbol;
        }
    }

    public BaseStatNode() {
        position = null;
    }

    public void setPosition(int line, int symbol) {
        position = new Position(line, symbol);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public <T> T accept(AstVisitor<T> v) {
        return v.visit(this);
    }
}
