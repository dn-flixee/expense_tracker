pipeline {
  agent any
  stages {
    stage('Checkout Code') {
      steps {
        git(url: 'https://github.com/dn-flixee/expense_tracker', branch: 'master')
      }
    }

    stage('docker build') {
      steps {
        sh 'docker build -f Dockerfile .'
      }
    }

  }
}