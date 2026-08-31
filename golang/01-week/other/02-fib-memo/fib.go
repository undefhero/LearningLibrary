package fib

func fib(n int) int {
	if n <= 1 {
		return 1
	}

	memo := make([]int, n+1)

	for i := 1; i <= n; i++ {
		if i <= 2 {
			memo[i] = 1
		} else {
			memo[i] = memo[i-2] + memo[i-1]
		}
	}

	return memo[n]
}
