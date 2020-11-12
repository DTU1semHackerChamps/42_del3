public class Dice {

    /**
     * Declaration of the objects.
     */
    private int max = 6;    // Maximum face value.
    private int faceValue; // Current face value.


    /**
     * Constructor that takes an integer parameter.
     * @param value
     */
    public Dice(int value ){
        faceValue = value;
    }


    /**
     * Random method that gives a random number between 1 to 6.
     * @return Face value.
     */
   public int rollDice () {
       faceValue =(int) (Math.random() * max) + 1;
       return faceValue;
   }

   // Gets faceValue.
    public int getFaceValue() {
        return faceValue;
    }

    // Sets faceValue.
    public void setFaceValue(int value) {
        faceValue = value;
    }

    // Returns a String representation of object data.
    public String toString()
    {
        String result = "Øjne: " + faceValue;
        return result;
    }

}



