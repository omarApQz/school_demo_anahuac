var app = new Vue({
  el: '#app',
  data: {
    student: {
      firstName: "",
      lastName: "",
      email: "",
      gender: "",
      locationTest: "",
      entitySchool: "",
      degree: "",
      advisory: false
    },
    notifyOptions: {
      timeout: 9000,
      showProgressBar: true,
      closeOnClick: false,
      pauseOnHover: true,
      position: 'rightTop',
      helperNotificationCycle: true
    },
    secondName: "",
    secondLast: "",
    mathernName: ""
  },
  watch: {
    
  },
  computed: {

  },
  created: function() {
    console.log("Init student instance vue")
  },
  methods:{
    save() {
      console.log("Save student")
      this.$http.post('/student/save', this.student).then(response => {
        console.log(response)
        this.$snotify.warning("Estudiante Registrado", this.notifyOptions);
      }, response => {
        console.log(response)
      })
    }
  },
  mounted() {
  },
  components: {
  },
  filters: {
		removeExtendTime(time) {
			return time.replace(/T+(\w|:|.)+/, "")
		}
	},
})