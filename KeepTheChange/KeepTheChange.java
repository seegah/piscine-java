import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class KeepTheChange {
    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        // Convert the set to a sorted list (descending order)
        List<Integer> sortedCoins = new ArrayList<>(coins);
        Collections.sort(sortedCoins, Collections.reverseOrder());
        
        List<Integer>[] dp = new ArrayList[amount + 1];
        dp[0] = new ArrayList<>(); // Empty list for amount 0
        
        // Fill the dp table
        for (int i = 1; i <= amount; i++) {
            dp[i] = null; // Initialize with null to represent impossible
            
            for (int coin : sortedCoins) {
                if (i - coin >= 0 && dp[i - coin] != null) {
                    // We can use this coin
                    List<Integer> newChange = new ArrayList<>(dp[i - coin]);
                    newChange.add(coin);
                    
                    // Update if this solution has fewer coins or is the first solution found
                    if (dp[i] == null || newChange.size() < dp[i].size()) {
                        dp[i] = newChange;
                    }
                }
            }
        }
        
        return dp[amount];
    }
}