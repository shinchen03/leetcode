import sys


# class ListNode(Object):
#     def __init__(self, v):
#         self.value = v
#         self.left = None
#         self.right = None


def main():
    i = 0
    for line in sys.stdin:
        line = line.replace('\n', '')
        res = permutations(line)
        for r in res:
            print(r)


def calc_f(num):
    if num < 1024 and num > 0:
        return 1
    res = 0
    nums = []
    nums.append(num)
    while len(nums) > 0:
        n = nums.pop(0)
        if n >= 1024:
            nums.append(n - 1)
            nums.append(n - 1024)
        else:
            res += 1
    return res


def clac_ff(num):
    if num < 1024:
        return 1
    return clac_ff(num - 1) + clac_ff(num - 1024)


def permutations(str):
    l = len(str)
    if l == 0:
        return
    if l == 1:
        return str
    map = []
    res = []
    for i in range(l):
        if str[i] in map:
            continue
        map.append(str[i])
        for j in permutations(str[:i] + str[i + 1:]):
            res.append(str[i] + j)
    return res


def generateMatrix(self, n):
    left = top = 0
    right = n - 1
    bottom = n - 1
    num = 1
    result = [[0 for __ in range(n)] for __ in range(n)]
    while left < right and top < bottom:
        for i in range(left, right):
            result[top][i] = num
            num += 1
        for i in range(top, bottom):
            result[i][right] = num
            num += 1
        for i in range(right, left, -1):
            result[bottom][i] = num
            num += 1
        for i in range(bottom, top, -1):
            result[i][left] = num
            num += 1
        left += 1
        right -= 1
        top += 1
        bottom -= 1
    if left == right and top == bottom:
        result[top][left] = num
    return result


if __name__ == '__main__':
    main()
