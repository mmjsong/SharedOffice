<template>

    <v-card outlined>
        <v-card-title>
            Officeview # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="OfficeId" v-model="item.officeId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Desc" v-model="item.desc" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="ReviewCnt" v-model="item.reviewCnt" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="RsvId" v-model="item.rsvId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="RsvStatus" v-model="item.rsvStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PayId" v-model="item.payId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="PayStatus" v-model="item.payStatus" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'OfficeviewViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/officeviews/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

