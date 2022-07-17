package NumberGuessingGame;

/**
 * @author Hasan Acar
 */
public class NGG {

    private int gameLevel;
    private int rangeStart;
    private int rangeFinish;
    private int numberOfAttempts;
    private int exactNumber;

    public NGG(int gameLevel) {
        if (gameLevel < 1 || gameLevel > 4) {
            this.gameLevel = 1;
        } else {
            this.gameLevel = gameLevel;
        }
        setLevel();
        setExactNumber();
    }

    public int getRangeStart() {
        return rangeStart;
    }

    public int getRangeFinish() {
        return rangeFinish;
    }

    public boolean checkExactNumber(int number) {
        if (number == this.exactNumber) {
            return true;
        } else {
            return false;
        }
    }

    public String checkBigOrSmall(int number) {
        if (number < this.exactNumber) {
            return "big";
        } else {
            return "small";
        }
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    private void setExactNumber() {
        this.exactNumber = (int) (Math.random() * (rangeFinish - rangeStart)) + rangeStart;
    }

    private void setLevel() {
        // easy - medium - hard - expert
        switch (this.gameLevel) {
            case 2: // for middle
                this.rangeStart = 1; // start number of range
                this.rangeFinish = 100; // finish number of range
                this.numberOfAttempts = 10; // number of attempts
                break;
            case 3: // for hard
                this.rangeStart = 1;
                this.rangeFinish = 500;
                this.numberOfAttempts = 10;
                break;
            case 4: // for expert
                this.rangeStart = 1;
                this.rangeFinish = 1000;
                this.numberOfAttempts = 10;
                break;
            default:
                // for easy
                this.rangeStart = 1;
                this.rangeFinish = 10;
                this.numberOfAttempts = 5;
        }
    }

}

