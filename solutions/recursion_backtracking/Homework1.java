class Homework1 {
    public static void main(String args[]) {
        String dub1 = "xx";
        String dub2 = "xxx";
        String dub3 = "x";
        String dub4 = "xxTestxx";
        int dubsResult1 = countXWithDubs(dub1);
        int dubsResult2 = countXWithDubs(dub2);
        int dubsResult3 = countXWithDubs(dub3);
        int dubsResult4 = countXWithDubs(dub4);
        System.out.println(dub1 + " = " + dubsResult1);
        System.out.println(dub2 + " = " + dubsResult2);
        System.out.println(dub3 + " = " + dubsResult3);
        System.out.println(dub4 + " = " + dubsResult4);
        String test1 = "(())";
        String test2 = "((()";
        boolean result1 = validNesting(test1);
        boolean result2 = validNesting(test2);
        System.out.println(test1 + " = " + result1);
        System.out.println(test2 + " = " + result2);
    }

    /*
     * countXWithDubs
     */
    public static int countXWithDubs(String s) {
        // What if we have an empty string?
        if (s.length() == 0) {
            return 0;
        } else {
            if (s.charAt(0) == 'x') {
                if(s.length() > 1 && s.charAt(1) == 'x') {
                    return 2 + countXWithDubs(s.substring(2));
                } else {
                    return 1 + countXWithDubs(s.substring(1));
                }
            } else {
                return countXWithDubs(s.substring(1));
            }
        }    
    }

    /*
     * validNesting(String s)
     */
    public static boolean validNesting(String s) {
        if (s.length() == 0) {
            // By definition, the empty string is valid.
            return true;
        } else if (s.length() < 2) {
            // Any string with length 1 cannot be a valid nesting.
            return false;
        } else {
            if( s.charAt(0) == '(' && s.charAt(s.length() - 1) == ')' ) {
                /*
                 * The first and last characters nest properly, 
                 * so if what is inside them nests properly, the 
                 * whole thing does.
                 */
                return validNesting(s.substring(1, s.length() - 1));
            } else {
                // The first and last character do not nest properly
                return false;
            }
        }
    }
}
