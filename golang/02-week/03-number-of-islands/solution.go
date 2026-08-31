package numberofislands

func numIslands(grid [][]byte) int {
	if len(grid) == 0 {
		return 0

	}

	num := 0

	for y := 0; y < len(grid); y++ {
		for x := 0; x < len(grid[0]); x++ {
			if grid[y][x] != '0' {
				num++
				dfs(grid, x, y)
			}
		}
	}

	return num
}

func dfs(grid [][]byte, x, y int) {
	stack := [][]int{{y, x}}

	for len(stack) > 0 {
		last := len(stack) - 1
		cell := stack[last]
		stack = stack[:last]

		cy, cx := cell[0], cell[1]

		if cy >= 0 && cx >= 0 && cy < len(grid) && cx < len(grid[0]) {
			if grid[cy][cx] == '1' {
				grid[cy][cx] = '0'
				stack = append(stack, []int{cy, cx - 1})
				stack = append(stack, []int{cy - 1, cx})
				stack = append(stack, []int{cy, cx + 1})
				stack = append(stack, []int{cy + 1, cx})
			}
		}
	}
}
