import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ContactService } from 'src/app/contact.service';
import { NotificationService } from 'src/app/notification.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css'],
})
export class DeleteComponent implements OnInit {
  formsearch: FormGroup;
  contact: any;
  successrequest = false;
  constructor(
    private formBuilder: FormBuilder,
    private contactService: ContactService,
    private toastr: NotificationService
  ) {}

  ngOnInit(): void {
    this.formsearch = this.formBuilder.group({
      id: '',
    });
  }

  onSubmit() {
    if (this.formsearch.get('id') != null) {
      this.contactService
        .deleteContact(this.formsearch.get('id')!.value)
        .subscribe((data) => {
          console.log(data);
          this.successrequest = true;
          this.contact = data;
          this.toastr.showSuccess(
            'Cotnact supprimé avec succès',
            'Suppression'
          );
        });
    }
  }
}
