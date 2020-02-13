var app = new Vue({
  el: '#app',
  data: {
    student: {

    }
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