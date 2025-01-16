public class Second {
    public static int nbYear(int p0, double percent, int aug, int p) {

        int years = 0;
        double currentPopulation = p0;

        while (currentPopulation < p) {
            currentPopulation += Math.floor((currentPopulation * (percent / 100)) + aug);
            years++;
        }
        return years;
    }

    public void reverseString(char[] myArray) {
        int left = 0;
        int right = myArray.length -1;
        while (left < right) {
            char temp = myArray[left];
            myArray[left] = myArray[right];
            myArray[right] = temp;

            left++;
            right--;
        }
    }


    public static String convertToInitials(String name) {
        String[] parts = name.split(" ");
        String initials = parts[0].substring(0,1).toUpperCase() + "." + parts[1].substring(0,1).toUpperCase();
        return initials;
    }

    public static String fakeBin(String numberString) {
        StringBuilder result = new StringBuilder();
        for (char digit: numberString.toCharArray()) {
            if (digit < '5') {
                result.append('0');
            } else {
                result.append('1');
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(convertToInitials("Prince Hope"));
        System.out.println(convertToInitials("Walter Hope"));

        String input = "45385593107843568";
        String output = fakeBin(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }

}




