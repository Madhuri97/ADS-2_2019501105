'''@author Madhuri'''

import socket

def main():
	host = 'localhost'
	port = 8888
	s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
	s.bind((host, port))
	
    while True:
		data, addr = s.recvfrom(1024)
		giventext = str(data.decode())
		print('Text from client: ' + giventext)
		data = giventext.upper()
		print('Sending: ' + str(data))
		s.sendto(data.encode(), addr)
	
    s.close()

if __name__ == '__main__':
	main()
