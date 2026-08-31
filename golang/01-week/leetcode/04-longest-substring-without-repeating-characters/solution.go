package longestsubstringwithoutrepeatingcharacters

func lengthOfLongestSubstring(s string) int {
	seen := make(map[rune]int)
	left := 0
	maxLength := 0

	for right, char := range s {
		if index, ok := seen[char]; ok && index >= left {
			left = index + 1
		}

		seen[char] = right
		length := right - left + 1

		if length > maxLength {
			maxLength = length
		}
	}

	return maxLength
}

// for start <= len(s)-1 {
// 	str := s[start:]
// 	temp := []rune{}

// 	for _, char := range str {
// 		if slices.Contains(temp, char) {
// 			temp = []rune{}
// 			break
// 		}

// 		temp = append(temp, char)

// 		if len(temp) > len(res) {
// 			res = temp
// 		}
// 	}

// 	if start >= len(s) {
// 		break
// 	}
// 	start++
// }
