public class CleanExtract {
    public static String extract(String s) {
        if (s == null) return null;
        String[] substrings = s.split("\\|");
        StringBuilder result = new StringBuilder();
        
        for (String substring : substrings) {
            int firstPeriodIndex = substring.indexOf('.');
            int lastPeriodIndex = substring.lastIndexOf('.');
            
            if (firstPeriodIndex != -1 && lastPeriodIndex != -1) {
                String extracted;
                if (firstPeriodIndex == lastPeriodIndex) {
                    extracted = substring.substring(firstPeriodIndex + 1).trim();
                } else {
                    extracted = substring.substring(firstPeriodIndex + 1, lastPeriodIndex).trim();
                }
                
                if (!extracted.isEmpty()) {
                    if (result.length() > 0) {
                        result.append(" ");
                    }
                    result.append(extracted);
                }
            } else if (substring.trim().length() > 0 && !substring.contains(".")) {
                String extracted = substring.trim();
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(extracted);
            }
        }
        
        return result.toString();
    }
}