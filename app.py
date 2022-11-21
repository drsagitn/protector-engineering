f = open("words-utf8.txt", "r")
ret = {}
for line in f:
    line = line.rstrip()
    if line == "":
        continue
    key = "".join(sorted(line))
    if ret.get(key) is None:
        ret[key] = [line]
    else:
        ret[key].append(line)

for k, v in ret.items():
    if len(v) > 1:
        print(v)
    