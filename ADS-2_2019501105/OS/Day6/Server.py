import socket

def main():
    host = ''
    port = 5012

    s = socket.socket(socket.AF_INET, socket.SOCK_STEAM)
    s.bind((host, port))
    s.listen(3)
    message, address = s.accept()
    print("connection from: " + str(address))

    while True: 
    	data = message.recv(1024).decode('ASCII')
    	if not data:
    		break
    	print("from connected user" + str(data))
    	data = str(data).upper()
    	print("sending : " + str(data))
    	message.send(str(data).encode('ASCII'))
    message.close()

    if __name__ == '__main__':
    	main()