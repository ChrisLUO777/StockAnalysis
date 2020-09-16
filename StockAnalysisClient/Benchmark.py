import requests
from json import *
date=raw_input()
trans=date.split('.')
start=trans[0]
end=trans[1]
url2 = 'http://121.41.106.89:8010/api/benchmark/hs300?start='+start+'&end='+end+'&fields=open+close'
headers = {'X-Auth-Code': 'b675c6229386a50b4d8d464436070570'}
r = requests.get(url2,headers=headers)
out=JSONDecoder().decode(r.text)
print out["data"]["trading_info"]