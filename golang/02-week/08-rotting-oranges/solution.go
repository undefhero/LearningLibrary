package rottingoranges

func orangesRotting(grid [][]int) int {
	if len(grid) == 0 {
		return 0
	}

	queue := make([][]int, 0, len(grid)*len(grid[0]))
	fresh := 0

	for i := range len(grid) {
		for j := range len(grid[i]) {
			switch grid[i][j] {
			case 1:
				fresh++
			case 2:
				queue = append(queue, []int{i, j})
			}
		}
	}

	if fresh == 0 {
		return 0
	}

	directions := [4][2]int{
		{-1, 0},
		{1, 0},
		{0, -1},
		{0, 1},
	}

	wave := -1

	for len(queue) > 0 {
		levelSize := len(queue)
		wave++

		for range levelSize {
			orange := queue[0]
			queue = queue[1:]

			i, j := orange[0], orange[1]

			for _, d := range directions {
				oi, oj := i+d[0], j+d[1]

				if oi >= 0 && oi < len(grid) && oj >= 0 && oj < len(grid[oi]) && grid[oi][oj] == 1 {
					grid[oi][oj] = 2
					fresh--
					queue = append(queue, []int{oi, oj})
				}
			}
		}
	}

	if fresh > 0 {
		return -1
	}
	return wave
}
