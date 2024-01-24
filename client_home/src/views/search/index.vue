<template>
  <div class="page_search">
	<div class="warp">
	  <div class="container">
		<div class="row">
		  <div class="col-12">
			<div class="card_result_search">
			  <div class="title">搜索结果</div>

				<!-- 文章搜索结果 -->
			  <list_result_search
				:list="result_article"
				title="动物资讯"
				source_table="article"
			  ></list_result_search>


						  <list_result_search
				v-if="$check_action('/registered_user/list', 'get')"
				:list="result_registered_user_user_no"
				title="注册用户用户编号"
				source_table="registered_user"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/registered_user/list', 'get')"
				:list="result_registered_user_user_name"
				title="注册用户用户姓名"
				source_table="registered_user"
			  ></list_result_search>
									  <list_result_search
				v-if="$check_action('/volunteer/list', 'get')"
				:list="result_volunteer_volunteer_no"
				title="志愿者志愿者编号"
				source_table="volunteer"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/volunteer/list', 'get')"
				:list="result_volunteer_volunteer_name"
				title="志愿者志愿者姓名"
				source_table="volunteer"
			  ></list_result_search>
									  <list_result_search
				v-if="$check_action('/classification_of_rescue_animals/list', 'get')"
				:list="result_classification_of_rescue_animals_category_of_animal_rescue"
				title="救助动物分类救助动物类别"
				source_table="classification_of_rescue_animals"
			  ></list_result_search>
												  <list_result_search
				v-if="$check_action('/animal_rescue_information/list', 'get')"
				:list="result_animal_rescue_information_animal_name"
				title="救助动物信息动物名称"
				source_table="animal_rescue_information"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/animal_rescue_information/list', 'get')"
				:list="result_animal_rescue_information_animal_category"
				title="救助动物信息动物类别"
				source_table="animal_rescue_information"
			  ></list_result_search>
																								  <list_result_search
				v-if="$check_action('/rescue_contact_information/list', 'get')"
				:list="result_rescue_contact_information_name_of_rescue_station"
				title="救助联系方式救助站名称"
				source_table="rescue_contact_information"
			  ></list_result_search>
																				  <list_result_search
				v-if="$check_action('/rescue_contact_information/list', 'get')"
				:list="result_rescue_contact_information_contacts"
				title="救助联系方式联系人"
				source_table="rescue_contact_information"
			  ></list_result_search>
															  <list_result_search
				v-if="$check_action('/volunteer_application/list', 'get')"
				:list="result_volunteer_application_user_name"
				title="志愿者申请用户姓名"
				source_table="volunteer_application"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/volunteer_application/list', 'get')"
				:list="result_volunteer_application_application_time"
				title="志愿者申请申请时间"
				source_table="volunteer_application"
			  ></list_result_search>
																		  <list_result_search
				v-if="$check_action('/adoption_application/list', 'get')"
				:list="result_adoption_application_animal_name"
				title="领养申请动物名称"
				source_table="adoption_application"
			  ></list_result_search>
														  <list_result_search
				v-if="$check_action('/adoption_application/list', 'get')"
				:list="result_adoption_application_name_of_adopter"
				title="领养申请领养人姓名"
				source_table="adoption_application"
			  ></list_result_search>
															</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
</template>

<script>
import mixin from "../../mixins/page.js";
import list_result_search from "../../components/diy/list_result_search.vue";

export default {
  mixins: [mixin],
  data() {
	return {
	  "query": {
		word: "",
	  },
	  "result_article": [],
						"result_registered_user_user_no":[],
								"result_registered_user_user_name":[],
									"result_volunteer_volunteer_no":[],
								"result_volunteer_volunteer_name":[],
									"result_classification_of_rescue_animals_category_of_animal_rescue":[],
												"result_animal_rescue_information_animal_name":[],
								"result_animal_rescue_information_animal_category":[],
																								"result_rescue_contact_information_name_of_rescue_station":[],
																				"result_rescue_contact_information_contacts":[],
															"result_volunteer_application_user_name":[],
								"result_volunteer_application_application_time":[],
																		"result_adoption_application_animal_name":[],
														"result_adoption_application_name_of_adopter":[],
													};
  },
  methods: {
	/**
	 * 获取文章
	 */
	get_article() {
	  this.$get("~/api/article/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_article = json.result.list;
		}
	  });
	},

				/**
	 * 获取user_no
	 */
	get_registered_user_user_no(){
		this.$get("~/api/registered_user/get_list?like=0", { page: 1, size: 10, "user_no": this.query.word }, (json) => {
		  if (json.result) {
			var result_registered_user_user_no = json.result.list;
			result_registered_user_user_no.map(o => o.title = o['user_no'])
	  			this.result_registered_user_user_no = result_registered_user_user_no
		 	}
		});
	},
						/**
	 * 获取user_name
	 */
	get_registered_user_user_name(){
		this.$get("~/api/registered_user/get_list?like=0", { page: 1, size: 10, "user_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_registered_user_user_name = json.result.list;
			result_registered_user_user_name.map(o => o.title = o['user_name'])
	  			this.result_registered_user_user_name = result_registered_user_user_name
		 	}
		});
	},
							/**
	 * 获取volunteer_no
	 */
	get_volunteer_volunteer_no(){
		this.$get("~/api/volunteer/get_list?like=0", { page: 1, size: 10, "volunteer_no": this.query.word }, (json) => {
		  if (json.result) {
			var result_volunteer_volunteer_no = json.result.list;
			result_volunteer_volunteer_no.map(o => o.title = o['volunteer_no'])
	  			this.result_volunteer_volunteer_no = result_volunteer_volunteer_no
		 	}
		});
	},
						/**
	 * 获取volunteer_name
	 */
	get_volunteer_volunteer_name(){
		this.$get("~/api/volunteer/get_list?like=0", { page: 1, size: 10, "volunteer_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_volunteer_volunteer_name = json.result.list;
			result_volunteer_volunteer_name.map(o => o.title = o['volunteer_name'])
	  			this.result_volunteer_volunteer_name = result_volunteer_volunteer_name
		 	}
		});
	},
							/**
	 * 获取category_of_animal_rescue
	 */
	get_classification_of_rescue_animals_category_of_animal_rescue(){
		this.$get("~/api/classification_of_rescue_animals/get_list?like=0", { page: 1, size: 10, "category_of_animal_rescue": this.query.word }, (json) => {
		  if (json.result) {
			var result_classification_of_rescue_animals_category_of_animal_rescue = json.result.list;
			result_classification_of_rescue_animals_category_of_animal_rescue.map(o => o.title = o['category_of_animal_rescue'])
	  			this.result_classification_of_rescue_animals_category_of_animal_rescue = result_classification_of_rescue_animals_category_of_animal_rescue
		 	}
		});
	},
										/**
	 * 获取animal_name
	 */
	get_animal_rescue_information_animal_name(){
		this.$get("~/api/animal_rescue_information/get_list?like=0", { page: 1, size: 10, "animal_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_animal_rescue_information_animal_name = json.result.list;
			result_animal_rescue_information_animal_name.map(o => o.title = o['animal_name'])
	  			this.result_animal_rescue_information_animal_name = result_animal_rescue_information_animal_name
		 	}
		});
	},
						/**
	 * 获取animal_category
	 */
	get_animal_rescue_information_animal_category(){
		this.$get("~/api/animal_rescue_information/get_list?like=0", { page: 1, size: 10, "animal_category": this.query.word }, (json) => {
		  if (json.result) {
			var result_animal_rescue_information_animal_category = json.result.list;
			result_animal_rescue_information_animal_category.map(o => o.title = o['animal_category'])
	  			this.result_animal_rescue_information_animal_category = result_animal_rescue_information_animal_category
		 	}
		});
	},
																						/**
	 * 获取name_of_rescue_station
	 */
	get_rescue_contact_information_name_of_rescue_station(){
		this.$get("~/api/rescue_contact_information/get_list?like=0", { page: 1, size: 10, "name_of_rescue_station": this.query.word }, (json) => {
		  if (json.result) {
			var result_rescue_contact_information_name_of_rescue_station = json.result.list;
			result_rescue_contact_information_name_of_rescue_station.map(o => o.title = o['name_of_rescue_station'])
	  			this.result_rescue_contact_information_name_of_rescue_station = result_rescue_contact_information_name_of_rescue_station
		 	}
		});
	},
																		/**
	 * 获取contacts
	 */
	get_rescue_contact_information_contacts(){
		this.$get("~/api/rescue_contact_information/get_list?like=0", { page: 1, size: 10, "contacts": this.query.word }, (json) => {
		  if (json.result) {
			var result_rescue_contact_information_contacts = json.result.list;
			result_rescue_contact_information_contacts.map(o => o.title = o['contacts'])
	  			this.result_rescue_contact_information_contacts = result_rescue_contact_information_contacts
		 	}
		});
	},
													/**
	 * 获取user_name
	 */
	get_volunteer_application_user_name(){
		this.$get("~/api/volunteer_application/get_list?like=0", { page: 1, size: 10, "user_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_volunteer_application_user_name = json.result.list;
			result_volunteer_application_user_name.map(o => o.title = o['user_name'])
	  			this.result_volunteer_application_user_name = result_volunteer_application_user_name
		 	}
		});
	},
						/**
	 * 获取application_time
	 */
	get_volunteer_application_application_time(){
		this.$get("~/api/volunteer_application/get_list?like=0", { page: 1, size: 10, "application_time": this.query.word }, (json) => {
		  if (json.result) {
			var result_volunteer_application_application_time = json.result.list;
			result_volunteer_application_application_time.map(o => o.title = o['application_time'])
	  			this.result_volunteer_application_application_time = result_volunteer_application_application_time
		 	}
		});
	},
																/**
	 * 获取animal_name
	 */
	get_adoption_application_animal_name(){
		this.$get("~/api/adoption_application/get_list?like=0", { page: 1, size: 10, "animal_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_adoption_application_animal_name = json.result.list;
			result_adoption_application_animal_name.map(o => o.title = o['animal_name'])
	  			this.result_adoption_application_animal_name = result_adoption_application_animal_name
		 	}
		});
	},
												/**
	 * 获取name_of_adopter
	 */
	get_adoption_application_name_of_adopter(){
		this.$get("~/api/adoption_application/get_list?like=0", { page: 1, size: 10, "name_of_adopter": this.query.word }, (json) => {
		  if (json.result) {
			var result_adoption_application_name_of_adopter = json.result.list;
			result_adoption_application_name_of_adopter.map(o => o.title = o['name_of_adopter'])
	  			this.result_adoption_application_name_of_adopter = result_adoption_application_name_of_adopter
		 	}
		});
	},
												
  },
  components: { list_result_search },
	created(){
    this.query.word = this.$route.query.word || "";
  },
  mounted() {
	this.get_article();
					this.get_registered_user_user_no();
							this.get_registered_user_user_name();
								this.get_volunteer_volunteer_no();
							this.get_volunteer_volunteer_name();
								this.get_classification_of_rescue_animals_category_of_animal_rescue();
											this.get_animal_rescue_information_animal_name();
							this.get_animal_rescue_information_animal_category();
																							this.get_rescue_contact_information_name_of_rescue_station();
																			this.get_rescue_contact_information_contacts();
														this.get_volunteer_application_user_name();
							this.get_volunteer_application_application_time();
																	this.get_adoption_application_animal_name();
													this.get_adoption_application_name_of_adopter();
												  },
  watch: {
	$route() {
	  $.push(this.query, this.$route.query);
	  this.get_article();
				  this.get_registered_user_user_no();
						  this.get_registered_user_user_name();
							  this.get_volunteer_volunteer_no();
						  this.get_volunteer_volunteer_name();
							  this.get_classification_of_rescue_animals_category_of_animal_rescue();
										  this.get_animal_rescue_information_animal_name();
						  this.get_animal_rescue_information_animal_category();
																						  this.get_rescue_contact_information_name_of_rescue_station();
																		  this.get_rescue_contact_information_contacts();
													  this.get_volunteer_application_user_name();
						  this.get_volunteer_application_application_time();
																  this.get_adoption_application_animal_name();
												  this.get_adoption_application_name_of_adopter();
													},
  },
};
</script>

<style scoped>
.card_search {
  text-align: center;
}
.card_result_search>.title {
  text-align: center;
  padding: 10px 0;
}
</style>
