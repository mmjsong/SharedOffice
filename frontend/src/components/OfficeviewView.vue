<template>

    <v-data-table
        :headers="headers"
        :items="officeview"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'OfficeviewView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "officeId", value: "officeId" },
                { text: "desc", value: "desc" },
                { text: "reviewCnt", value: "reviewCnt" },
                { text: "rsvId", value: "rsvId" },
                { text: "rsvStatus", value: "rsvStatus" },
                { text: "payId", value: "payId" },
                { text: "payStatus", value: "payStatus" },
            ],
            officeview : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/officeviews'))

            temp.data._embedded.officeviews.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.officeview = temp.data._embedded.officeviews;
        },
        methods: {
        }
    }
</script>

