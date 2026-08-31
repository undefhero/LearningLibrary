package numberofislands

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestNumIslandsSingleIsland(t *testing.T) {
	grid := [][]byte{
		{'1', '1', '1', '1', '0'},
		{'1', '1', '0', '1', '0'},
		{'1', '1', '0', '0', '0'},
		{'0', '0', '0', '0', '0'},
	}

	assert.Equal(t, 1, numIslands(grid))
}

func TestNumIslandsThreeIslands(t *testing.T) {
	grid := [][]byte{
		{'1', '1', '0', '0', '0'},
		{'1', '1', '0', '0', '0'},
		{'0', '0', '1', '0', '0'},
		{'0', '0', '0', '1', '1'},
	}

	assert.Equal(t, 3, numIslands(grid))
}
