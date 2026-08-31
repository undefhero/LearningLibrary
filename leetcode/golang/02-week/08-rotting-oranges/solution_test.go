package rottingoranges

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestOrangesRottingExample1(t *testing.T) {
	grid := [][]int{
		{2, 1, 1},
		{1, 1, 0},
		{0, 1, 1},
	}

	assert.Equal(t, 4, orangesRotting(grid))
}

func TestOrangesRottingExample2(t *testing.T) {
	grid := [][]int{
		{2, 1, 1},
		{0, 1, 1},
		{1, 0, 1},
	}

	assert.Equal(t, -1, orangesRotting(grid))
}

func TestOrangesRottingExample3(t *testing.T) {
	grid := [][]int{
		{0, 2},
	}

	assert.Equal(t, 0, orangesRotting(grid))
}
