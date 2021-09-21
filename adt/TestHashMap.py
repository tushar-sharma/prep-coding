from collections import defaultdict

track = defaultdict(list)

track["a"] = 100
track["b"] = 200
track["c"] = 300


print(track["b"])

print(track["z"])

if "c" in track:
    print("c is found in dict")


if 300 in track.values():
    print("300 exist")


for key, value in track.items():
    print("key is %s and value is %s" % (key, value))
