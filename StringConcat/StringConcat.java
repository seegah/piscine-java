public class StringConcat {
    public static String concat(String s1, String s2) {
        if (s1 == null && s2 == null) return null;
        return (s1 != null ? s1 : "") + (s2 != null ? s2 : "");
    }
}