const nodemailer = require('nodemailer');

const serverSupportMail = 'mardroid.apps@gmail.com'
const serverSupportPassword = process.env.EMAIL_PASSWORD

const transporter = nodemailer.createTransport({
  service: 'gmail',
  auth: {
    user: serverSupportMail,
    pass: serverSupportPassword
  }
});

function sendOptMail(email, otpCode){
  
  var mailOptions = {
    from: 'mardroid.apps@gmail.com',
    to: email,
    subject: 'Chitikka password assistance',
    text: 'To authenticate, please use the following One Time Password (OTP): \n' + otpCode + '\nDo not share this OTP with anyone.\n Chitikka takes your account security very seriously.'+
    '\Chitikka will never ask you to disclose or varify your Chitikka password, OTP, credit card, or banking account number'
  };
  
  
  transporter.sendMail(mailOptions, function(error, info){
    if (error) {
      console.log(error);
    } else {
      console.log('Email sent: ' + info.response);
    }
  });    
  
}

function getRandomInt(min, max) {
  min = Math.ceil(min);
  max = Math.floor(max);
  return Math.floor(Math.random() * (max - min)) + min; 
}


module.exports.sendOptMail = sendOptMail;
module.exports.getRandomInt = getRandomInt;



