impl Solution { //Bueno's solution
    pub fn number_of_arrays(s: String, k: i32) -> i32 {
        let s_bytes = s.as_bytes();
        let m = 1_000_000_007;
        let mut dp = vec![0; s_bytes.len()+1];

        dp[s_bytes.len()] = 1;

        for i in (0..s.len()).rev() {
            let mut sum = 0 as usize;
            
            for j in i..s.len() {
                sum = sum * 10 + (s_bytes[j] - b'0') as usize;
               
                if sum > k as usize || sum == 0 {
                    break;
                }

                dp[i] = (dp[i] + (dp[j+1] % m)) % m;
            }
        }
        dp[0] as i32
    }
}
