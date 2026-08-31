package maxdepthofbinarytree

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestMinDepth(t *testing.T) {
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

	assert.Equal(t, 2, minDepth(root))
}

func TestMinDepthRightSkewedTree(t *testing.T) {
	root := &TreeNode{
		Val: 2,
		Right: &TreeNode{
			Val: 3,
			Right: &TreeNode{
				Val: 4,
				Right: &TreeNode{
					Val: 5,
					Right: &TreeNode{
						Val: 6,
					},
				},
			},
		},
	}

	assert.Equal(t, 5, minDepth(root))
}

func TestMinDepthStopsAtNearestLeaf(t *testing.T) {
	root := &TreeNode{
		Val: 1,
		Left: &TreeNode{
			Val: 2,
			Left: &TreeNode{
				Val: 4,
			},
			Right: &TreeNode{
				Val: 5,
			},
		},
		Right: &TreeNode{
			Val: 3,
		},
	}

	assert.Equal(t, 2, minDepth(root))
}
