import mechanics.Sudoku;

public class Main {

    public static void main(String[] args) {
        Sudoku s1 = new Sudoku();

        /* TestCase 1
        s1.insertNumber(8, 0, 0);
        s1.insertNumber(2, 2, 0);
        s1.insertNumber(5, 8, 0);
        s1.insertNumber(4, 2, 1);
        s1.insertNumber(3, 7, 1);
        s1.insertNumber(8, 8, 1);
        s1.insertNumber(5, 0, 2);
        s1.insertNumber(9, 3, 2);
        s1.insertNumber(2, 6, 2);
        s1.insertNumber(4, 4, 4);
        s1.insertNumber(6, 6, 4);
        s1.insertNumber(9, 7, 4);
        s1.insertNumber(5, 2, 5);
        s1.insertNumber(6, 5, 5);
        s1.insertNumber(4, 6, 5);
        s1.insertNumber(2, 8, 5);
        s1.insertNumber(2, 4, 6);
        s1.insertNumber(9, 5, 6);
        s1.insertNumber(6, 7, 6);
        s1.insertNumber(6, 2, 7);
        s1.insertNumber(3, 3, 7);
        s1.insertNumber(1, 7, 7);
        s1.insertNumber(3, 0, 8);
        s1.insertNumber(4, 1, 8);
        s1.insertNumber(5, 3, 8);

        s1.fillImNumbers();

        System.out.println(s1);

        System.out.println("0.  "+s1.showImNumbers(0, 0));
        System.out.println("1.  "+s1.showImNumbers(1, 0));
        System.out.println("2.  "+s1.showImNumbers(3, 0));
        System.out.println("3.  "+s1.showImNumbers(4, 0));
        System.out.println("4.  "+s1.showImNumbers(5, 0));
        System.out.println("5.  "+s1.showImNumbers(6, 0));
        System.out.println("6.  "+s1.showImNumbers(7, 0));
        System.out.println("7.  "+s1.showImNumbers(0, 1));
        System.out.println("8.  "+s1.showImNumbers(1, 1));
        System.out.println("9.  "+s1.showImNumbers(3, 1));
        System.out.println("10. "+s1.showImNumbers(4, 1));
        System.out.println("11. "+s1.showImNumbers(5, 1));
        System.out.println("12. "+s1.showImNumbers(6, 1));
        System.out.println("13. "+s1.showImNumbers(1, 2));
        System.out.println("14. "+s1.showImNumbers(2, 2));
        System.out.println("15. "+s1.showImNumbers(4, 2));
        System.out.println("16. "+s1.showImNumbers(5, 2));
        System.out.println("17. "+s1.showImNumbers(7, 2));
        System.out.println("18. "+s1.showImNumbers(8, 2));
        System.out.println("19. "+s1.showImNumbers(0, 3));
        System.out.println("20. "+s1.showImNumbers(1, 3));
        System.out.println("21. "+s1.showImNumbers(2, 3));
        System.out.println("22. "+s1.showImNumbers(3, 3));
        System.out.println("23. "+s1.showImNumbers(4, 3));
        System.out.println("24. "+s1.showImNumbers(5, 3));
        System.out.println("25. "+s1.showImNumbers(6, 3));
        System.out.println("26. "+s1.showImNumbers(7, 3));
        System.out.println("27. "+s1.showImNumbers(8, 3));
        System.out.println("28. "+s1.showImNumbers(0, 4));
        System.out.println("29. "+s1.showImNumbers(1, 4));
        System.out.println("30. "+s1.showImNumbers(2, 4));
        System.out.println("31. "+s1.showImNumbers(3, 4));
        System.out.println("32. "+s1.showImNumbers(5, 4));
        System.out.println("33. "+s1.showImNumbers(8, 4));
        System.out.println("34. "+s1.showImNumbers(0, 5));
        System.out.println("35. "+s1.showImNumbers(1, 5));
        System.out.println("36. "+s1.showImNumbers(3, 5));
        System.out.println("37. "+s1.showImNumbers(4, 5));
        System.out.println("38. "+s1.showImNumbers(7, 5));
        System.out.println("39. "+s1.showImNumbers(0, 6));
        System.out.println("40. "+s1.showImNumbers(1, 6));
        System.out.println("41. "+s1.showImNumbers(2, 6));
        System.out.println("42. "+s1.showImNumbers(3, 6));
        System.out.println("43. "+s1.showImNumbers(6, 6));
        System.out.println("44. "+s1.showImNumbers(8, 6));
        System.out.println("45. "+s1.showImNumbers(0, 7));
        System.out.println("46. "+s1.showImNumbers(1, 7));
        System.out.println("47. "+s1.showImNumbers(4, 7));
        System.out.println("48. "+s1.showImNumbers(5, 7));
        System.out.println("49. "+s1.showImNumbers(6, 7));
        System.out.println("50. "+s1.showImNumbers(8, 7));
        System.out.println("51. "+s1.showImNumbers(2, 8));
        System.out.println("52. "+s1.showImNumbers(4, 8));
        System.out.println("53. "+s1.showImNumbers(5, 8));
        System.out.println("54. "+s1.showImNumbers(6, 8));
        System.out.println("55. "+s1.showImNumbers(7, 8));
        System.out.println("56. "+s1.showImNumbers(8, 8));
        */

        s1.insertImNumber(5, 1, 0, false);
        s1.insertImNumber(6, 0, 1, false);
        s1.insertImNumber(6, 1, 1, false);
        s1.insertImNumber(4, 0, 0, false);
        s1.insertImNumber(4, 0, 1, false);

        while (s1.onlyImToNumber());
        System.out.println(s1);
        System.out.println(s1.showImNumbers(1, 0));
        System.out.println(s1.showImNumbers(6, 1));
        System.out.println(s1.showImNumbers(1, 1));
        System.out.println(s1.showImNumbers(0, 0));
    }
}
