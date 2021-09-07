def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def testApp() {
    echo "building the application..."
    sh 'mvn test'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'narendra', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t narendranadh82/pipeline:V82 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push narendranadh82/pipeline:V82'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
