from flask import Flask, request, jsonify


# Define the Flask app
app = Flask(__name__)

subscribers = {}
subject = ""

def home():
  return "Hello from Flask!"

@app.route('/', methods=['GET'])
def root():
  print(f"Hello at the root")
  return jsonify({'main endpoint':'Ack'})

@app.route('/list-subscribers', methods=['GET'])
def listSubscribers():
  return jsonify(subscribers)

# Windows> curl.exe -X POST -H "Content-Type: application/json" -d "{\"name\":\"Alice\",\"URI\":\"http://good.site.com\"}" http://localhost:5000/add-subscriber

@app.route('/add-subscriber', methods=['POST'])
def addSubscriber():
  data = request.json
  name = data.get('name')
  URI = data.get('URI')
  subscribers[name] = URI
  print(f"You entered: Name={name}, Address={URI}")
  return jsonify({'message': f'You sent name: {name} and address: {URI}'})

@app.route('/delete-subscriber', methods=['DELETE'])
def deleteSubscriber():
  data = request.json
  name = data.get('name')
  del subscribers[name]
  print(f"You deleted: Name={name}")
  return jsonify({'message': f'You sent name: {name} '})

@app.route('/update-and-notify', methods=['POST'])
def updateAndNotifyAllSubscribers():
  data = request.json
  subject = data.get('subject-update')
  print(f"You updated the subject to: {subject}")
  for key in subscribers.keys():
    print(f"Notifying {key} at {subscribers[key]} of the new subject: {subject}")
  return jsonify({'message': f'You updated subject to: {subject} '})

if __name__ == '__main__':
  app.run(host='0.0.0.0', port=5000, debug=True)