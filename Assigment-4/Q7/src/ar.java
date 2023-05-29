class Solution{
    def maxCount(self, m: int, n: int, ops: List[List[int]]) -> int:
        xs, ys = defaultdict(int), defaultdict(int)
        for op in ops:
            # print(op, xs, ys)
            for i in range(1, op[0]+1):
                xs[i] += 1
            for j in range(1, op[1]+1):
                ys[j] += 1
        maxX, maxY, maxXval, maxYval = m, n, 0, 0
        # print(xs, ys)
        for k,v in xs.items():
            if v >= maxXval:
                maxX = k
                maxXval = v
        for k,v in ys.items():
            if v >= maxYval:
                maxY = k
                maxYval = v
        return maxX*maxY
}