'''
Q5
ある地点から別の地点へ荷物を送るとき、複数の配送センターを経由して最終的な配送センターに荷物が送られるものとします。以下の仕様のもと、ある配送センターの住所と別の配送センターの住所が与えられたときに、どのような経路で荷物が送られるかを出力するプログラムを作成してください。

配送センターの情報は、ウェブAPIからJSON形式で取得することができます。配送センターの情報のURLはhttps://pn-c9759a75.herokuapp.com/${address} の形式で、${address}の部分には実際の住所の文字列が入ります。また、https://pn-c9759a75.herokuapp.com/にアクセスすると、配送センターの住所の一覧を取得することができます。

配送センターの情報は、具体的には下記のようなものです。

{
  "address": "us/newyork/newyork",
  "routes": {
    "uk": "uk/england/london",
    "us/california": "us/california/losangeles",
    "us/newyork/buffalo": "us/newyork/buffalo",
    "default": "us/california/losangeles"
  }
}
配送センターの情報には、住所（address）と経路（routes）とが含まれています。住所は、国、地域、都市を/でつなげた形式で表現されます。経路は、次に荷物を送る配送センターを示しています。経路は、宛先と配送センターの住所の組み合わせで、宛先が荷物の住所に前方一致する場合に、その配送センターに送られます。また、defaultは特別な宛先で、他に合致する宛先がなかったときには、その配送センターに送られるということを示しています。

たとえば、先ほどのJSONのような情報があったときに、荷物をus/newyork/newyorkからus/california/sandiegoという住所に送りたいとします。経路の宛先にはus/californiaがあるので、荷物は次にus/california/losangelesへ送られます。荷物をjapan/tokyo/shinjukuに送りたいときには、荷物はdefaultであるus/california/losangelesへと送られます。

想定される実行例は下記の通りです。

$ ruby q3.rb us/newyork/newyork us/california/sandiego
us/newyork/newyork
us/california/losangeles
us/california/sandiego

'''

import urllib.request
import json
import sys
import codecs


def main():

	argv = sys.argv
	if (len(argv) != 3):
		print('invalid args')
		exit();
	x = argv[1]
	y = argv[2]
	print(x)
	if (x is y):
		exit()
	next = x
	pre = [x]
	while (next != y):
		next = getNext(next, y)
		if (next in pre):
			print('error')
			exit()
		pre.append(next)
		print(next)
		x = next

	
def getNext(x, y):
	url2 = 'https://pn-c9759a75.herokuapp.com/' + x
	res = urllib.request.urlopen(url2)
	address = json.loads(res.read().decode('utf-8'))
	strs = y.split('/')
	temp = strs[0] + '/' + strs[1]
	if (y in address['routes']):
		print(y)
		exit()
	elif (temp in address['routes']):
		next = address['routes'][temp]
	elif (strs[0] in address['routes']):
		next = address['routes'][strs[0]]
	else:
		next = address['routes']['default']
	return next
	
	
if __name__ == '__main__':
	main()
