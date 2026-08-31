package binarytreelevelordertraversal

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestLevelOrder(t *testing.T) {
	root := &TreeNode{
		Val: 3,
		Left: &TreeNode{
			Val: 9,
		},
		Right: &TreeNode{
			Val: 20,
			Left: &TreeNode{
				Val: 15,
			},
			Right: &TreeNode{
				Val: 7,
			},
		},
	}

	expected := [][]int{{3}, {9, 20}, {15, 7}}

	assert.Equal(t, expected, levelOrder(root))
}

func TestLevelOrderSingleNode(t *testing.T) {
	root := &TreeNode{Val: 1}
	expected := [][]int{{1}}

	assert.Equal(t, expected, levelOrder(root))
}

func TestLevelOrderEmptyTree(t *testing.T) {
	expected := [][]int{}

	assert.Equal(t, expected, levelOrder(nil))
}
