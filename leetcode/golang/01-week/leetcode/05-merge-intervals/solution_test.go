package mergeintervals

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestMerge(t *testing.T) {
	assert.Equal(t, [][]int{[]int{1, 6}, []int{8, 10}, []int{15, 18}}, merge([][]int{
		[]int{1, 3},
		[]int{2, 6},
		[]int{8, 10},
		[]int{15, 18},
	}))

	assert.Equal(t, [][]int{[]int{1, 7}}, merge([][]int{
		[]int{4, 7},
		[]int{1, 4},
	}))
}
